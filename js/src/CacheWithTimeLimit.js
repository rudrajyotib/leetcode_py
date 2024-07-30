class TimeLimitedCache {
    constructor(){
        this.cache = new Map();
        this.sum = 0;
        this.elementCount = 0;
    }

    set = function(key, value, duration) {
        if (this.cache.has(key)){
            var node = this.cache.get(key);
            this.sum -= node.value;
            this.sum += value;
            clearTimeout(node.timeout);
            this.cache.set(key, new NodeValue(value, setTimeout(()=>{
                this.removeElement(key);
            }, duration)));
        }else {
            this.sum += value;
            ++this.elementCount;
            this.cache.set(key, new NodeValue(value, setTimeout(()=>{
                this.removeElement(key);
            }, duration)));
        }
    }

    get = function(key) {
        if (this.cache.has(key) === true){
            return this.cache.get(key).value;
        }
        return -1;
    }

    count = function() {
        return this.elementCount;
    }

    average = function() {
        if (this.elementCount === 0 ){
            return 0;
        }
        return (Number) (this.sum / this.elementCount);
    }

    removeElement = function(key) {
        let val = this.cache.get(key);
        --this.elementCount;
        this.sum -= val.value;
        this.cache.delete(key);
    }
};

class NodeValue {
    constructor(value, timeoutFunction){
        this.value = value;
        this.timeout = timeoutFunction;
    }
}

/** 
 * @param {number} key
 * @param {number} value
 * @param {number} duration time until expiration in ms
 * @return {boolean} if un-expired key already existed
 */
TimeLimitedCache.prototype.set = function(key, value, duration) {
    if (this.cache.has(key)){
        var node = this.cache.get(key);
        this.cache.sum -= node.value;
        clearTimeout(node.timeout);
        this.cache.set(key, new NodeValue(value, setTimeout(()=>{
            this.removeElement(key);
        }, duration)));
    }else {
        this.cache.set(key, new NodeValue(value, setTimeout(()=>{
            this.removeElement(key);
        }, duration)));
    }
};

/** 
 * @param {number} key
 * @return {number} value associated with key
 */
TimeLimitedCache.prototype.get = function(key) {
    if (this.cache.has(key)){
        return this.cache.get(key).value;
    }
    return -1;
};

/** 
 * @return {number} count of non-expired keys
 */
TimeLimitedCache.prototype.count = function() {
    return this.cache.count;
};


/** 
 * @return {number} average of non-expired values
 */
TimeLimitedCache.prototype.average = function() {
    if (this.cache.count === 0 ){
        return 0;
    }
    return (Number) (this.cache.sum / this.cache.average);
};


/** 
 * @return {number} count of non-expired keys
 */
TimeLimitedCache.prototype.removeElement = function(key) {
    val = this.cache.get(key);
    --this.cache.count;
    this.cache.sum -= this.cache.get(key).value
};

/**
 * const timeLimitedCache = new TimeLimitedCache()
 * timeLimitedCache.set(1, 42, 1000); // false
 * timeLimitedCache.get(1) // 42
 * timeLimitedCache.count() // 1
 */

module.exports = {TimeLimitedCache}