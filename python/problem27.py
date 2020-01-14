class Solution(object):
    def removeElement(self, nums, val):
        count = 0
        
        for n in nums:
            if n == val:
                count += 1
                
        for i in range(count):
            nums.remove(val)
            
        return len(nums)
