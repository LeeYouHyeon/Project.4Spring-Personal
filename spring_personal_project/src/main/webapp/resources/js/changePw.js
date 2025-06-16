/**
 * 
 */
const [prev, newPw, newCheck, changeBtn, validationArea, matchArea] = ['prev', 'newPw', 'newCheck', 'changeBtn', 'validationArea', 'matchArea'].map(e => document.getElementById(e));

let pwValid = false;
let pwMatch = true;

function validate() {
  const [input, match] = [newPw, newCheck].map(e => e.value);
  let msgVal = '';

  if (input.length < 8) {
    msgVal = '비밀번호가 너무 짧습니다.';
    pwValid = false;
  } else if (!/[a-z]/.test(input)) {
    msgVal = '알파벳 소문자를 포함해야 합니다.';
    pwValid = false;
  } else if (!/[A-Z]/.test(input)) {
    msgVal = '알파벳 대문자를 포함해야 합니다.';
    pwValid = false;
  } else if (!/[0-9]/.test(input)) {
    msgVal = '숫자를 포함해야 합니다.';
    pwValid = false;
  } else {
    msgVal = '사용가능한 비밀번호입니다.';
    pwValid = true;
  }
  validationArea.innerHTML = `<span class="${pwValid ? 'text-success' : 'text-danger'}">${msgVal}</span>`;

  pwMatch = input == match;
  matchArea.innerHTML = pwMatch ? '' : '<span class="text-danger">비밀번호가 맞지 않습니다.</span>';
}

newPw.onchange = validate;
newCheck.onchange = validate;

changeBtn.onclick = () => {
  if (prev.value == '') {
    prev.focus();
    return;
  }
  if (!pwValid) {
    newPw.focus();
    return;
  }
  if (!pwMatch) {
    newCheck.focus();
    return;
  }

  document.querySelector('form').submit();
}