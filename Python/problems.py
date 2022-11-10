def bubble_sort(nums):
    for i in range(len(nums)):
        for j in range(len(nums) - 1):
            if nums[j] > nums[j+1]:
                t = nums[j+1]
                nums[j+1] = nums[j]
                nums[j] = t
    return nums;

nums = [ 1, 5, 6, 11, 17, -21, 51, -1, 1, 2, 34 ]
sorted_nums = bubble_sort(nums)
print(sorted_nums)
    
