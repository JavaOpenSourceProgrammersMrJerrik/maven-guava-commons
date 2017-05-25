package com.mangocity.guava.cas;
import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

import sun.misc.Unsafe;

public class AtomicLongDefinition extends Number implements java.io.Serializable {
    private static final long serialVersionUID = 1927816293512124184L;

    // setup to use Unsafe.compareAndSwapLong for updates
    private static  Unsafe unsafe;
    private static final long valueOffset;

    /**
     * Returns whether underlying JVM supports lockless CompareAndSet
     * for longs. Called only once and cached in VM_SUPPORTS_LONG_CAS.
     */
    private static native boolean VMSupportsCS8();

    static {
      try {
    	Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
  		theUnsafe.setAccessible(true);
  		unsafe = (Unsafe) theUnsafe.get(null);
        valueOffset = unsafe.objectFieldOffset
            (AtomicLongDefinition.class.getDeclaredField("value"));
      } catch (Exception ex) { throw new Error(ex); }
    }

    private volatile long value;

    /**
     * Creates a new AtomicLongDefinition with the given initial value.
     *
     * @param initialValue the initial value
     */
    public AtomicLongDefinition(long initialValue) {
        value = initialValue;
    }

    /**
     * Creates a new AtomicLongDefinition with initial value {@code 0}.
     */
    public AtomicLongDefinition() {
    }

    /**
     * Gets the current value.
     *
     * @return the current value
     */
    public final long get() {
        return value;
    }

    /**
     * Sets to the given value.
     *
     * @param newValue the new value
     */
    public final void set(long newValue) {
        value = newValue;
    }

    /**
     * Eventually sets to the given value.
     *
     * @param newValue the new value
     * @since 1.6
     */
    public final void lazySet(long newValue) {
        unsafe.putOrderedLong(this, valueOffset, newValue);
    }

    int i = 0;
    
    public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	/**
     * Atomically sets to the given value and returns the old value.
     *
     * @param newValue the new value
     * @return the previous value
     */
    public final long getAndSet(long newValue) {
        while (true) {
        	synchronized (this) {
				i++;
			}
            long current = get();
            if (compareAndSet(current, newValue))
            	System.out.println("总共有: " + i + "线程争用");
                return current;
        }
    }

    /**
     * Atomically sets the value to the given updated value
     * if the current value {@code ==} the expected value.
     *
     * @param expect the expected value
     * @param update the new value
     * @return true if successful. False return indicates that
     * the actual value was not equal to the expected value.
     */
    public final boolean compareAndSet(long expect, long update) {
        return unsafe.compareAndSwapLong(this, valueOffset, expect, update);
    }

    /**
     * Atomically sets the value to the given updated value
     * if the current value {@code ==} the expected value.
     *
     * <p>May <a href="package-summary.html#Spurious">fail spuriously</a>
     * and does not provide ordering guarantees, so is only rarely an
     * appropriate alternative to {@code compareAndSet}.
     *
     * @param expect the expected value
     * @param update the new value
     * @return true if successful.
     */
    public final boolean weakCompareAndSet(long expect, long update) {
        return unsafe.compareAndSwapLong(this, valueOffset, expect, update);
    }
    
    ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    /**
     * Atomically increments by one the current value.
     *
     * @return the previous value
     */
    public final long getAndIncrement() {
        while (true) {
            long current = get();
            long next = current + 1;
           threadLocal.set(Thread.currentThread().getId() + "-current: " + current);
            if (compareAndSet(current, next)){
                return current;
            }else{
            	synchronized (this) {
    				i++;
    			}
            }
        }
    }

    /**
     * Atomically decrements by one the current value.
     *
     * @return the previous value
     */
    public final long getAndDecrement() {
        while (true) {
            long current = get();
            long next = current - 1;
            if (compareAndSet(current, next))
                return current;
        }
    }

    /**
     * Atomically adds the given value to the current value.
     *
     * @param delta the value to add
     * @return the previous value
     */
    public final long getAndAdd(long delta) {
        while (true) {
            long current = get();
            long next = current + delta;
            if (compareAndSet(current, next))
                return current;
        }
    }

    /**
     * Atomically increments by one the current value.
     *
     * @return the updated value
     */
    public final long incrementAndGet() {
        for (;;) {
            long current = get();
            long next = current + 1;
            if (compareAndSet(current, next))
                return next;
        }
    }

    /**
     * Atomically decrements by one the current value.
     *
     * @return the updated value
     */
    public final long decrementAndGet() {
        for (;;) {
            long current = get();
            long next = current - 1;
            if (compareAndSet(current, next))
                return next;
        }
    }

    /**
     * Atomically adds the given value to the current value.
     *
     * @param delta the value to add
     * @return the updated value
     */
    public final long addAndGet(long delta) {
        for (;;) {
            long current = get();
            long next = current + delta;
            if (compareAndSet(current, next))
                return next;
        }
    }

    /**
     * Returns the String representation of the current value.
     * @return the String representation of the current value.
     */
    public String toString() {
        return Long.toString(get());
    }


    public int intValue() {
        return (int)get();
    }

    public long longValue() {
        return get();
    }

    public float floatValue() {
        return (float)get();
    }

    public double doubleValue() {
        return (double)get();
    }

}
