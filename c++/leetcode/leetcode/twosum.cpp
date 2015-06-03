#include <vector>
#include <iostream>
#include <unordered_map>

using namespace std;

namespace twosum {
    /*
    Given an array of integers, find two numbers such that they add up to a specific target number.

    The function twoSum should return indices of the two numbers such that they add up to the target,
    where index1 must be less than index2. Please note that your returned answers (both index1 and index2)
    are not zero-based.

    You may assume that each input would have exactly one solution.

    Input: numbers={2, 7, 11, 15}, target=9
    Output: index1=1, index2=2

    */
    class Solution {
    public:
        vector<int> twoSum(vector<int>& nums, int target) {
            // target-nums[i] -> i
            unordered_map<int, vector<int>> reverse;
            // scan: O(n)
            for (int i = 0; i < nums.size(); i++)
            {
                int v = nums[i];
                auto p = reverse.find(v);
                if (p == reverse.end())
                {
                    pair<int, vector<int>> e;
                    e.first = v;
                    e.second.push_back(i);
                    reverse.insert(e);
                }
                else 
                {
                    p->second.push_back(i);
                }
            }
            // search: O(n)
            vector<int> result;
            for (int i = 0; i < nums.size(); i++)
            {
                int v = nums[i];
                auto p = reverse.find(target - v);
                if (p != reverse.end())
                {
                    for (auto l = p->second.begin(); l != p->second.end(); l++)
                    {
                        if (*l != i)
                        {
                            if (i < *l)
                            {
                                result.push_back(i + 1);
                                result.push_back(*l + 1);
                                break;
                            }
                            else if (*l > i)
                            {
                                result.push_back(*l + 1);
                                result.push_back(i + 1);
                                break;
                            }
                        }
                    }
                }
            }
            return result;
        }
        static void test() {
            vector<int> input({ 2, 7, 11, 15 });
            int target = 9;
            Solution s;
            vector<int> &result = s.twoSum(input, target);
            for (int v : result) {
                cout << v << ',';
            }
            cout << endl;
        }
    };

}