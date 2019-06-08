package com.general.data.structures.and.algorithms.greedymethod;

import java.util.*;


public class KnapSackProblem {

    public void findItems(Map<Integer, ProfitsAndWeights> map) {
        List<ProfitsAndWeights> profitsAndWeightsList = new ArrayList<>();

        for (Integer i : map.keySet()) {
            System.out.println(i + " " + map.get(i).toString());
            profitsAndWeightsList.add(map.get(i));
        }

        Collections.sort(profitsAndWeightsList);

        for (ProfitsAndWeights p : profitsAndWeightsList) {
            System.out.println(p.toString());
        }

        int weightLimit = 0;
        int counter = 0;
        int profitForItemsAdded = 0;
        while(weightLimit < 15) {
            System.out.println(profitsAndWeightsList.get(counter).profit + " " + profitForItemsAdded + " "
                    + profitsAndWeightsList.get(counter).weight + " " + weightLimit);
            if (weightLimit + profitsAndWeightsList.get(counter).weight > 15) {
                int remainingWeight = 15 - weightLimit;
                System.out.println(remainingWeight + " " + profitsAndWeightsList.get(counter).profit / remainingWeight +
                        " " + profitsAndWeightsList.get(counter).weight / remainingWeight);
                profitForItemsAdded += (profitsAndWeightsList.get(counter).profit / profitsAndWeightsList.get(counter).weight) * remainingWeight;
                weightLimit +=  remainingWeight;
                counter++;
            } else {
                profitForItemsAdded += profitsAndWeightsList.get(counter).profit;
                weightLimit += profitsAndWeightsList.get(counter).weight;
                counter++;
            }

        }

        System.out.println(" Total profit " + profitForItemsAdded + " weightLimit  " + weightLimit);

    }

}

class KnapSackProblemTest {
    public static void main(String[] args) {

        //Let's make our knapSack objects
        Map<Integer, ProfitsAndWeights>  knapSack = new HashMap<>();
        knapSack.put(1, new ProfitsAndWeights(10, 2));
        knapSack.put(2, new ProfitsAndWeights(5, 3));
        knapSack.put(3, new ProfitsAndWeights(15, 5));
        knapSack.put(4, new ProfitsAndWeights(7, 7));
        knapSack.put(5, new ProfitsAndWeights(6, 1));
        knapSack.put(6, new ProfitsAndWeights(18, 4));
        knapSack.put(7, new ProfitsAndWeights(3, 1));

        KnapSackProblem k = new KnapSackProblem();
        k.findItems(knapSack);

    }
}