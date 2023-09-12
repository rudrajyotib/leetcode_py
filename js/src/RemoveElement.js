//https://leetcode.com/problems/remove-element/description/

/**
 * @param {number[]} nums
 * @param {number} val
 * @return {number}
 */
 var removeElement = function(nums, val) {
    if (nums.length == 0){
        return 0
    }

    let elementIndex = -1;

    for (let index = 0; index < nums.length ; index++){
        if (nums[index] != val){
            ++elementIndex
            nums[elementIndex] = nums[index]
        }
    }

    return elementIndex + 1

};

module.exports = {removeElement}