const { assert, expect } = require("chai");
const { describe } = require("mocha");

describe("should remove duplicates", ()=>{

    let removeFunction

    beforeEach(()=>{
        removeFunction = require("../src/RemoveDuplicatesFromSortedArray").removeDuplicates
    })

    it("should support repeating elements", ()=>{
        let testArr = [1,1,1,2,2,2,3,3,3]
        let unique = removeFunction(testArr)
        expect(unique).equals(3)
        expect(testArr.slice(0,3)).to.deep.equal([1,2,3])
    })

    it("should support single element array", ()=>{
            let testArr = [1]
            let unique = removeFunction(testArr)
            expect(unique).equals(1)
            expect(testArr.slice(0,1)).to.deep.equal([1])
    })

    it("should support array without duplicates", ()=>{
            let testArr = [1,2,3,4]
            let unique = removeFunction(testArr)
            expect(unique).equals(4)
            expect(testArr.slice(0,4)).to.deep.equal([1,2,3,4])
    })

    it("should support array with only last element repeated", ()=>{
            let testArr = [1,2,3,4,4,4,4,4]
            let unique = removeFunction(testArr)
            expect(unique).equals(4)
            expect(testArr.slice(0,4)).to.deep.equal([1,2,3,4])
    })

    it("should support array with only first element repeated", ()=>{
            let testArr = [1,1,1,1,1,2,3,4]
            let unique = removeFunction(testArr)
            expect(unique).equals(4)
            expect(testArr.slice(0,4)).to.deep.equal([1,2,3,4])
    })

})