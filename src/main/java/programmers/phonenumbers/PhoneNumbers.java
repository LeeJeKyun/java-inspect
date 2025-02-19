package programmers.phonenumbers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PhoneNumbers {
    public static void main(String[] args) {
        String[] arr = new String[]{"1235","567","123","88","12"};
        Arrays.sort(arr);
        for(String s : arr) {
            System.out.println("s = " + s);
        }
    }
}

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for(int i=0; i< phone_book.length; i++) {
            for(int j=i+1; j< phone_book.length; j++) {
                if(phone_book[j].startsWith(phone_book[i])) return false;
            }
        }
        return true;
    }
    public boolean solution2(String[] phone_book) {

        Map<String, Integer> map = new HashMap<>();

        for(String phone : phone_book) {
            map.put(phone, 0);
        }

        for(int i=0; i< phone_book.length; i++) {
            String phone = phone_book[i];
            for(int j=0; j<phone.length(); j++) {
                if(map.containsKey(phone.substring(0, j))) return false;
            }
        }

        return true;
    }
}