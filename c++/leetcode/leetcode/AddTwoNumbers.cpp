namespace AddTwoNumbers {

    // Definition for singly-linked list.
    struct ListNode {
        int val;
        ListNode *next;
        ListNode(int x) : val(x), next(nullptr) {}
    };
    /*
    You are given two linked lists representing two non-negative numbers. 
    The digits are stored in reverse order and each of their nodes contain 
    a single digit. Add the two numbers and return it as a linked list.

    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8
    */
    class Solution {
    public:
        ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
            ListNode *result = nullptr;
            ListNode *prev = nullptr;
            int acc = 0;
            while (l1 != nullptr && l2 != nullptr)
            {
                int sum = l1->val + l2->val + acc;
                acc = sum / 10;
                sum = sum - acc * 10;
                ListNode *curr = new ListNode(sum);
                if (prev == nullptr)
                {
                    result = prev = curr;
                } 
                else
                {
                    prev->next = curr;
                    prev = curr;
                }
                l1 = l1->next;
                l2 = l2->next;
            }
            while (l1 != nullptr)
            {
                int sum = l1->val + acc;
                acc = sum / 10;
                sum = sum - acc * 10;
                prev->next = new ListNode(sum);
                prev = prev->next;
                l1 = l1->next;
            }
            while (l2 != nullptr)
            {
                int sum = l2->val + acc;
                acc = sum / 10;
                sum = sum - acc * 10;
                prev->next = new ListNode(sum);
                prev = prev->next;
                l2 = l2->next;
            }
            if (acc > 0)
            {
                prev->next = new ListNode(acc);
                acc = 0;
            }

            return result;
        }

        static void test() {
            Solution s;
            ListNode l1(2);
            l1.next = &ListNode(4);
        }
    };
}