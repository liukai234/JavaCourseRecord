/*
 * @Description: 
 * @LastEditors: liukai
 * @Date: 2020-05-21 20:07:12
 * @LastEditTime: 2020-05-21 20:19:25
 * @FilePath: /leetcode/1-两数之和.cpp
 */ 
#include <bits/stdc++.h>

using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> a;
        for(int i = 0; i < nums.size(); i++) {
            for(int j = i + 1; j < nums.size(); j ++){
                if(nums[i] + nums[j] == target) { 
                    a.push_back(i);
                    a.push_back(j);
                }
            }
        }
        return a;
    }
};