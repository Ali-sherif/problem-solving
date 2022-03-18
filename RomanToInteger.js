const roma = {
  I: 1,
  V: 5,
  X: 10,
  L: 50,
  C: 100,
  D: 500,
  M: 1000
};

const subtraction = {
  IV: 4,
  IX: 9,
  XL: 40,
  XC: 90,
  CD: 400,
  CM: 900
};

const romanToInt = (num) => {
  let output = 0;
  const arr = [...num];
  for (let i = 0; i < arr.length; i++) {
    let result = subtraction[arr[i] + arr[i + 1]];
    if (result) {
      output += result;
      ++i;
      continue;
    }
    output += roma[arr[i]];
  }
  return output;
};

const number = 'MCMXCIV'.toUpperCase();
const output = romanToInt(number);
console.log(output);
