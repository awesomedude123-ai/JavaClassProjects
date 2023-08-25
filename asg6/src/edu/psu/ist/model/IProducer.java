package edu.psu.ist.model;

public interface IProducer<U extends Comparable<U>> {
    public abstract U produce();
}
