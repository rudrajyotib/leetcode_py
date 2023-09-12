const { expect } = require("chai");
const { describe } = require("mocha");
const { removeElement } = require("../src/RemoveElement");

describe('remove element', ()=>{
    
    it('should remove element from middle', ()=>{
        let arr = [1,2,3,3,4]
        removed = removeElement(arr, 3)
        expect(removed).equal(3)
        expect(arr.slice(0,3)).to.deep.equal([1,2,4])
    })
    
    it('should remove element from begin and end', ()=>{
        let arr = [3,3,3,1,2,3,3,4,3,3,3]
        removed = removeElement(arr, 3)
        expect(removed).equal(3)
        expect(arr.slice(0,3)).to.deep.equal([1,2,4])
    })
    
    it('should remove all elements', ()=>{
        let arr = [3,3,3,3,3,3]
        removed = removeElement(arr, 3)
        expect(removed).equal(0)
        expect(arr).to.deep.equal([3,3,3,3,3,3])
    })
    
    it('should support empty array', ()=>{
        let arr = []
        removed = removeElement(arr, 3)
        expect(removed).equal(0)
    })
    
})