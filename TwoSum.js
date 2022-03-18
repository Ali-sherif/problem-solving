const twoSum = (array, target) => {
  let obj = {};
  const result = [];
  for (const key in array) {
    const property = target - array[key];
    if (obj.hasOwnProperty(array[key])) {
      const index = obj[array[key]];
      result.push([index, key]);
    }
    obj[property] = key;
  }
  return result;
};
const array = [1, 2, 3],
  target = 5;

const output = twoSum(array, target);
