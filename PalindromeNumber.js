const isPalindrome = (num) => {
  if (num < 0) return false;
  const str = num.toString();
  if (str.length == 1) return true;
  const arr = [...str];
  for (let i = 0, j = arr.length - 1; i < j; i++) {
    if (!(arr[i] == arr[j])) return false;
    j--;
    continue;
  }
  return true;
};
const number = 123;
const output = isPalindrome(number);
