const loopFunction = (array) => {
  let obj = {};
  for (let item in array) {
    if (obj.hasOwnProperty(array[item])) {
      const data = obj[array[item]];
      data.push(item);
      obj[array[item]] = data;
      continue;
    }
    obj[array[item]] = new Array(item);
  }
  return obj;
};

const minDominoRotations = function (tops, bottoms) {
  const topObj = loopFunction(tops);
  bottomObj = loopFunction(bottoms);
  if (Object.keys(topObj).length == 1 || Object.keys(bottomObj).length == 1)
    return 0;

  let commonKeys = [];
  for (key in topObj) {
    if (!bottomObj.hasOwnProperty(key)) delete topObj[key];
    else commonKeys.push(key);
  }

  let mySet;
  let commonKey;
  for (key of commonKeys) {
    const temp = [...topObj[key], ...bottomObj[key]];
    mySet = new Set(temp);

    if (mySet.size != tops.length) continue;
    commonKey = key;
    break;
  }
  if (!commonKey) return -1;
  console.log([...mySet]);
  const result =
    topObj[commonKey].length >= bottomObj[commonKey].length
      ? mySet.size - topObj[commonKey].length
      : mySet.size - bottomObj[commonKey].length;
  return result;
};

const tops = [2, 1, 2, 4, 2, 2],
  bottoms = [5, 2, 6, 2, 3, 2];
const output = minDominoRotations(tops, bottoms);
console.log(output);

/*
Runtime: 263 ms, faster than 5.42% of JavaScript online submissions for Minimum Domino Rotations For Equal Row.
Memory Usage: 77.7 MB, less than 5.91% of JavaScript online submissions for Minimum Domino Rotations For Equal Row.
*/
