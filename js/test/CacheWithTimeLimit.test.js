const { expect } = require("chai");
const { describe } = require("mocha");
const { TimeLimitedCache } = require("../src/CacheWithTimeLimit.js");
// const { ListNode } = require("../src/util/ListNode");

describe('should operate on time limit cache', ()=>{
    it("should work on cache", ()=>{
        var cache = new TimeLimitedCache();
        
        let val = cache.count();
        expect(cache.count()).to.equal(0);
        cache.set('A', 100, 2000);
        cache.set('B', 100, 1000);
        expect(cache.average()).to.equal(100);
        expect(cache.get('A')).to.equal(100);
        setTimeout(()=>{
            expect(cache.average()).to.equal(100);
            expect(cache.count()).to.equal(1);
            expect(cache.get('A')).to.equal(100);
            cache.set('A', 200, 3000);
            cache.set('C', 200, 500);
        }, 1500)
        setTimeout(()=>{
            expect(cache.average()).to.equal(200);
        }, 2500)
    })
})