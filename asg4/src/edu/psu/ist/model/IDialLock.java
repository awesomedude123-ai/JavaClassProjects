package edu.psu.ist.model;

public interface IDialLock {

    /**
     * This method will reset the entire moves list and set the current tick back to zero.
     */
    abstract void reset();

    /**
     * the left method will add a left move to the moves list and subtract 1 from the current tick variable
     * @param t
     */
    abstract void left(int t);

    /**
     * The right method will add a right move to the moves list and add 1 to the current tick variable.
     * @param t
     */
    abstract void right(int t);

    /**
     * The currentTick method returns the current tick of the lock.
     * @return
     */
    abstract int currentTick();

    /**
     * The pull method tests the sequence to see if it matches the secret. If it does, then returns true. Else, it returns false.
     * @return
     */
    abstract boolean pull();
}
