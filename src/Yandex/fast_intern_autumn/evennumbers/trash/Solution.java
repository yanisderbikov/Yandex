package Yandex.fast_intern_autumn.evennumbers.trash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// ошибка в скорости
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] arrInput = reader.readLine().split(" ");
        int n = Integer.parseInt(arrInput[0]);          // n - количество элементов
        int k = Integer.parseInt(arrInput[1]);          // k - количество раз переставить

        String[] arr = reader.readLine().split(" ");
        int[] nums = new int[n];


        int max = 0;
        int countChots = 0;  // сколько четных значений
        int firstSkips = 0;  // сколько первых элементов можно скипнуть
        for (int i = 0; i < nums.length; i++) {
            int currentInt = Integer.parseInt(arr[i]) % 2;
            nums[i] = currentInt;
            if (currentInt == 0 ){
                countChots++;
            } else if (firstSkips == i){ // тут нечетные
                firstSkips++;
            }



        }
        for (int i = firstSkips; i < n; i++) {
            int newMax = find(nums, k, firstSkips, countChots);
            firstSkips++;
            max = Math.max(max, newMax);
        }
        System.out.println(max);

    }

    static int find(int[] nums, int k, int firstSkips, int countChots){

//        firstSkips сколько элемнтов можно скипнуть сначала
        int maxLenght = 0;

        for (int i = firstSkips; i < nums.length; i++) {
            int currentInt = nums[i];
            if (maxLenght == countChots){
                return maxLenght;
            }
            if (currentInt == 0){
                maxLenght++;
            } else if (k != 0){
                k--;
                maxLenght++;
            } else {
                return maxLenght;
            }
        }

        return maxLenght;
    }
}

