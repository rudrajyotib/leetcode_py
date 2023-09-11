//https://leetcode.com/problems/remove-duplicates-from-sorted-array/

/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
    if (nums.length === 1 ){
        return 1
    }
    let uniqueCounter = 0

    for( let arrayCounter = 1; arrayCounter < nums.length ; arrayCounter ++ ){
        if (nums[arrayCounter] !== nums[uniqueCounter]){
            nums[++uniqueCounter] = nums[arrayCounter]
        }
    }

    return uniqueCounter+1

};

module.exports = {removeDuplicates}