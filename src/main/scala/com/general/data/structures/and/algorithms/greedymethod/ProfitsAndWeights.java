package com.general.data.structures.and.algorithms.greedymethod;

public class ProfitsAndWeights implements Comparable {
    int profit;
    int weight;
    double profitPerWeight;

    public ProfitsAndWeights(int profit, int weight) {
        this.profit = profit;
        this.weight = weight;
        this.profitPerWeight = profit / weight;
    }

    public int getProfit() {
        return profit;
    }

    public double getProfitPerWeight() {
        return profitPerWeight;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public void setProfitPerWeight(int profitPerWeight) {
        this.profitPerWeight = profitPerWeight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Object o) {
         if (this.profitPerWeight < ((ProfitsAndWeights) o).profitPerWeight) {
            return 1;
        } else return -1;
    }

    @Override
    public String toString() {
        return "ProfitsAndWeights( profit " + this.profit +
                ", weight " + this.weight + ", profitPerWeight " + this.profitPerWeight + " )";
    }
}
