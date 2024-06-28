let arr = [1,2,3,4,5,6,7];
let obj = {
    name : "rodger",
    dob : "10-10-1999"
}
let arr2 = [];

arr.forEach((value, index) => console.log(`${value} ${index}`));
arr2 = arr.filter(num=> num === 3);
for(let thing in obj){
    console.log(thing);
}

console.log(1 !== 2);
