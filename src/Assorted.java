import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;




public class Assorted {

    /**
     * Challenge 1
     * <p>
     * Takes a list of integer values represented as a mix of both
     * integer and string data types.
     *
     * @param list a list of integer values represented as a mix of both
     *             integer and string data types. E.g. [12, "54", "78", 16]
     * @return the sum of the elements in the list as if all elements were
     * integer data types.
     */
    public static int findSum(List<?> list) {
        int sum = 0;
        for (Object i : list) {
            if (i instanceof Integer) {
                sum += (Integer) i;
            } else if (i instanceof String) {
                sum += Integer.parseInt((String) i);
            }
        }
        return sum;
    }

    /**
     * Challenge 2
     * <p>
     * Takes a list of integers and strings and returns a new list containing
     * the integers only (filters the strings out).
     *
     * @param list a list of integer and string values. E.g [1, 2, "a", 5]
     * @return a list containing integers only.
     */
    public static List<Integer> filterStrings(List list) {
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof String) {
                list.remove(i);
                i = i - 1;
            }

        }
        System.out.println(list);
        return list;
    }

    /**
     * Challenge 3
     * <p>
     * Takes a list of strings and returns a new list that includes each element
     * prepended by the correct line number.
     *
     * @param list a list of string values e.g. ["a", "b", "c"]
     * @return a list where each element is prepended by the correct line number
     * e.g. ["1: a", "2: b", "3: c"]
     */
    public static List<String> lineNumbering(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, i + 1 + ": " + list.get(i));
        }
        System.out.println(list);
        return list;
    }

    /**
     * Challenge 4
     * <p>
     * There is a bus moving in the city which takes and drops some people at each
     * bus stop.
     * <p>
     * You are provided with a list (or array) of integer pairs. Elements of each pair
     * represent the number of people that get on the bus (the first item) and the number
     * of people that get off the bus (the second item) at a bus stop.
     * <p>
     * Your task is to return the number of people who are still on the bus after the last
     * bus stop (after the last array). Even though it is the last bus stop, the bus might
     * not be empty and some people might still be inside the bus, they are probably
     * sleeping there :D
     *
     * @param list a list of integer pairs.
     * @return the number of people who are still on the bus after the last stop.
     */
    public static int busStop(List<Integer[]> list) {
        int peoplestillon = 0;
        for (int i = 0; i < list.size(); i++) {
            peoplestillon += list.get(i)[0];
            peoplestillon -= list.get(i)[1];
        }
        return peoplestillon;

    }

    /**
     * Challenge 5
     * <p>
     * Given an array of ones and zeroes, convert the equivalent binary value to an integer.
     *
     * @param list a list of integer values. Each element is either a 0 or a 1.
     * @return the decimal value of the binary representation of the list.
     * Eg: [0, 0, 0, 1] is treated as 0001 which is the binary representation of 1.
     */
    public static int toBinary(List<Integer> list) {
        int value = 0;
        int count = 0;
        for (int i = list.size() - 1; i >= 0; i--) {

            int twos = (int) Math.pow(2, count);
            count += 1;

            //System.out.println(twos);
            value = value + list.get(i) * twos;
            System.out.println(value);
        }
        return value;
    }

    /**
     * Challenge 6
     * <p>
     * Your goal is to implement a method which subtracts one list
     * from another and returns the result.
     * <p>
     * It should remove all values from listA, which are present in listB keeping their order.
     * If a value is present in listB, all of its occurrences must be removed from listA.
     *
     * @param listA a list of integer values.
     * @param listB a list of integer values.
     * @return a list that contains the difference between listB and listA.
     * e.g. subtractList([1,2], [1]) returns [2]
     * subtractList([1,2,2,2,3], [2]) returns [1,3]
     */
    public static List<Integer> subtractList(List<Integer> listA, List<Integer> listB) {
        //System.out.println(listA);
        //System.out.println(listB);
        for (Object i : listB) {
            for (int j = 0; j < listA.size(); j++) {
                if (listA.get(j) == i) {
                    listA.remove(j);
                    j -= 1;
                }
            }
        }
        //System.out.println(listA);
        return listA;
    }

    /**
     * Challenge 7
     * <p>
     * Your goal is to implement a method which takes a list of integers and sorts the odd
     * numbers in ascending order while leaving the even numbers in their original positions.
     *
     * @param list a list of integers.
     * @return a list where the odd integers have been sorted in ascending order and the even
     * integers remain in their original position.
     */
    public static List<Integer> sortOdd(List<Integer> list) {
        ArrayList<Integer> oddint = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            if (num % 2 != 0) {
                oddint.add(num);
            }
        }
        Collections.sort(oddint);
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            if (num % 2 != 0) {
                list.set(i, oddint.get(count));
                count += 1;
            }
        }
        return list;
    }

    /**
     * Challenge 8
     * <p>
     * Your goal is to implement a method which takes two values (a lower bound and an upper
     * bound) and returns a list of numbers that are between the lower bound and upper bound
     * (inclusive) that have a certain property.
     * <p>
     * The property is as follows:
     * <p>
     * The number 89 is the first integer with more than one digit whose individual digits
     * can sum to the value 89 by raising each digit to the power of the place or column of
     * which it resides. For example, 89 = 8^1 + 9^2. The next number having this property is
     * 135. 135 = 1^1 + 3^2 + 5^3.
     *
     * @param lowerBound an integer representing the lower bound.
     * @param upperBound an integer representing the upper bound.
     * @return a list containing all the numbers between lowerBound and upperBound (inclusive)
     * that meet the property mentioned above.
     * e.g. uniqueNumber(1,10) returns [1,2,3,4,5,6,7,8,9]
     * uniqueNumber(1,100) returns [1,2,3,4,5,6,7,8,9,89]
     */
    public static List<Integer> uniqueNumber(int lowerBound, int upperBound) {
        ArrayList<Integer> listofnumbers = new ArrayList<>();
        ArrayList<Integer> finallist = new ArrayList<>();
        for (int i = lowerBound; i < upperBound + 1; i++) {
            listofnumbers.add(i);
        }

        for (int i : listofnumbers) {
            ArrayList<Integer> split = new ArrayList<>();
            int number = i;
            int temp = number;
            while (temp > 0) {
                int digit = temp % 10;
                split.add(digit);
                temp /= 10;
            }
            Collections.reverse(split);
            // and then write up some code about like the other to the power of stuff
            int count = 1;
            int finalnum = 0;
            for (int numero : split) {
                finalnum += (int) Math.pow(numero, count);
                count += 1;
            }
            if (finalnum == number) {
                finallist.add(number);
            }
        }

        return finallist;
    }

    /**
     * Challenge 9
     * <p>
     * Alice and Bob were on a holiday. Both of them took many pictures of the places they've
     * been, and now they want to show Charlie their entire collection. However, Charlie doesn't
     * like these sessions, since the motif usually repeats. He isn't fond of seeing the Eiffel
     * tower 40 times.
     * <p>
     * He tells them that he will only sit for the session if they show the same motif at most N
     * times. Luckily, Alice and Bob are able to encode the motif as a number. Can you help them
     * to remove numbers such that their list contains each number only up to N times, without
     * changing the order?
     *
     * @param list a list of motifs.
     * @param n    the maximum number of occurrences of a specific motif that is allowed.
     * @return a list containing each motif at most n times.
     * e.g. filterNTimes([1,2,3,1,2,1,2,3], 2) returns [1,2,3,1,2,3]
     * filterNTimes([20,37,20,21], 1) returns [20,37,21]
     */
    // i need to figure out how hashmaps work jesususussusussuususus
    public static List<Integer> filterNTimes(List<Integer> list, int n) {
        List<Integer> filteredList = new ArrayList<>();
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int motif : list) {
            int count = countMap.getOrDefault(motif, 0);
            if (count < n) {
                filteredList.add(motif);
                countMap.put(motif, count + 1);
            }
        }

        return filteredList;
    }

    /**
     * Challenge 10
     * <p>
     * Once upon a time, on a way through the old wild mountainous west,…
     * … a man was given directions to go from one point to another. The directions were
     * "NORTH", "SOUTH", "WEST", "EAST". Clearly "NORTH" and "SOUTH" are opposite, "WEST"
     * and "EAST" too.
     * <p>
     * Going to one direction and coming back the opposite direction right away is a needless
     * effort. Since this is the wild west, with dreadful weather and not much water, it's
     * important to save yourself some energy, otherwise you might die of thirst!
     * <p>
     * How I crossed a mountainous desert the smart way.
     * The directions given to the man are, for example, the following:
     * <p>
     * ["NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"].
     * <p>
     * You can immediately see that going "NORTH" and immediately "SOUTH" is not reasonable,
     * better stay to the same place! So the task is to give to the man a simplified version
     * of the plan. A better plan in this case is simply:
     * <p>
     * ["WEST"]
     * <p>
     * Your task is to write a method which will take a list of strings and returns a list
     * of strings with the needless directions removed.
     *
     * @param directions a list of directions.
     * @return a list with the needless directions removed.
     * e.g. wildWest(["NORTH", "SOUTH", "EAST", "WEST"]) returns []
     * wildWest(["NORTH", "EAST", "WEST", "SOUTH", "WEST", "WEST"]) returns
     * ["WEST", "WEST"]
     */
    public static List<String> wildWest(List<String> directions) {
        /*
        System.out.println(directions);
        int north = 0;
        int south = 0;
        int east = 0;
        int west = 0;
        for(Object i: directions){
            if (i.equals("NORTH")){
                north +=1;
            }else if(i.equals("SOUTH")){
                south +=1;
            }else if (i.equals("EAST")){
                east +=1;
            }else{
                west +=1;
            }
        }
        ArrayList<String> finallist = new ArrayList<>();

        int northsouth = north - south;
        int eastwest = east-west;
        if (northsouth > 0){
            for(int i = 0; i< northsouth; i++){
                finallist.add("NORTH");
            }
        }else if(northsouth < 0){
            for(int i = 0; i< Math.abs(northsouth); i++){
                finallist.add("SOUTH");
            }
        }
        if (eastwest >0){
            for(int i = 0; i< eastwest; i++){
                finallist.add("EAST");
            }
        }else if(eastwest < 0){
            for(int i = 0; i< Math.abs(eastwest); i++){
                finallist.add("WEST");
            }
        }
        System.out.println(finallist);
        return finallist;
         */
        ///List<String> filteredList = new ArrayList<>();
        System.out.println(directions);
        boolean done = false;
        while (done != true) {
            int count = 0;
            for (int i = 0; i < directions.size() - 1; i++) {
                if ((directions.get(i).equals("NORTH") && directions.get(i + 1).equals("SOUTH")) || (directions.get(i).equals("SOUTH") && directions.get(i + 1).equals("NORTH"))) {
                    directions.remove(i + 1);
                    directions.remove(i);
                    i -= 1;
                    count += 1;
                } else if ((directions.get(i).equals("EAST") && directions.get(i + 1).equals("WEST")) || (directions.get(i).equals("WEST") && directions.get(i + 1).equals("EAST"))) {
                    directions.remove(i + 1);
                    directions.remove(i);
                    count += 1;
                }
            }
            if (count == 0) {
                done = true;
            }

        }
        System.out.println(directions);
        return (directions);

    }
// how is this wrong???

    /**
     * Challenge 11
     * <p>
     * There is a queue for the self-checkout tills at the supermarket. Your task is to write a
     * method to calculate the total time required for all the customers to check out!
     * <p>
     * There is only queue serving many tills.
     * The order of the queue never changes.
     * The front person in the queue (the first element in queue) proceeds to a till as soon
     * as it becomes free.
     *
     * @param queue     a list of queue times. Each element represents a customer and how long
     *                  in minutes it will take them to check out.
     * @param tillsOpen the number of tills currently available for customers to use.
     * @return an integer that represents how long it will take for all the customers to check
     * out.
     * e.g. queueTime([5,3,4], 1) returns 12
     * queueTime([10,2,3,3], 2) returns 10
     * queueTime([2,3,10], 2) returns 12
     */
    public static int queueTime(List<Integer> queue, int tillsOpen) {
        /*
        PriorityQueue<Integer> tills = new PriorityQueue<>(tillsOpen);


        for (int i = 0; i < tillsOpen; i++) {
            tills.offer(0);//.offer i think just puts the numbers into the list?
        }
        //System.out.println(tills);

        for (int time : queue) {
            int nextTill = tills.poll(); //.poll() returns the element in front of it and gets rid of that element
            tills.offer(nextTill + time);
        }
        System.out.println(tills);

        return findMax(tills);
    }

    private static int findMax(PriorityQueue<Integer> tills) {
        int max = Integer.MIN_VALUE;
        for (int time : tills) {
            max = Math.max(max, time);
        }
        return max;
    }
    */
    /*
        List<Integer> filteredList = new ArrayList<>();
        int[] tills = new int[tillsOpen];
        int minutes = 0;
        boolean token = false;

        for(int i:queue){
            filteredList.add(i);
        }

        while(token != true){
            for(int i = 0; i < tills.length; i++) {
                if(tills[i]==0) {
                    tills[i] = filteredList.get(0);
                    filteredList.remove(0);
                }
                //tills[i] = tills[i]-1;
                //System.out.println(tills[i]);
            }
            minutes +=1;
            //System.out.println("---");
            boolean isZero = true;
            for (int i : tills) {
                if (i != 0) {
                    isZero = false;
                    break;
                }
            }
            if (isZero == false){
                token = true;
            }
        }
        //System.out.println("done!!!!!!!!!!!");
        System.out.println(minutes);
        return minutes;
    }

     */
        ArrayList<Integer> tills = new ArrayList<>();
        for (int i = 0; i < tillsOpen; i++) {
            tills.add(0);
        }
        for (int i = 0; i < queue.size(); i++) {
            tills.set(0, tills.get(0) + queue.get(i));
            Collections.sort(tills);
        }
        return tills.get(tills.size() - 1);

    }

}
