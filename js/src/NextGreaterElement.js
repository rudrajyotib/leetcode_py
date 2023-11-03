//https://leetcode.com/problems/next-greater-element-i/description/

var nextGreaterElement = function (nums1, nums2) {
    var stack = []
    var map = new Map()
    map.set(nums2[nums2.length - 1], -1)
    stack.push(nums2[nums2.length - 1])

    for (let counter = nums2.length - 2; counter >= 0; counter--) {
        while (stack.length > 0) {
            let element = stack.pop()
            if (element > nums2[counter]) {
                stack.push(element)
                break;
            }
        }
        if (stack.length == 0) {
            map.set(nums2[counter], -1)
        } else {
            map.set(nums2[counter], stack[stack.length - 1])
        }
        stack.push(nums2[counter])
    }
    let result = []

    for (let counter = 0; counter < nums1.length; counter++) {
        result.push(map.get(nums1[counter]))
    }

    return result
};

module.exports = { nextGreaterElement }