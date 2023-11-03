const { expect } = require("chai");
const { describe } = require("mocha");
const { nextGreaterElement } = require("../src/NextGreaterElement");

describe('should find next greater element', () => {
    it('set 1', () => {
        let result = nextGreaterElement([4, 1, 2], [1, 3, 4, 2])
        expect(result).to.deep.equal([-1, 3, -1])
    })

    it('set 1', () => {
        let result = nextGreaterElement([2, 4], [1, 2, 3, 4])
        expect(result).to.deep.equal([3, -1])
    })
})