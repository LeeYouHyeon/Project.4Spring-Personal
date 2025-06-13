/**
 * 
 */

const [id, pw, pwCheck, nick, email,
  idCheckBtn, registerBtn,
  idResultArea, pwValidationArea, pwMatchArea,
] = ['id', 'pw', 'pwCheck', 'name', 'email',
  'idCheckBtn', 'registerBtn',
  'idResultArea', 'pwValidationArea', 'pwMatchArea']
  .map(e => document.getElementById(e));

let idResult = undefined;
let pwValid = false;
let pwMatch = true;

// 아이디 확인
id.onchange = () => {
  idResult = undefined;
};

idCheckBtn.addEventListener('click', () => {
  const input = id.value;
  if (input == '' || idResult != undefined) return;

  isRegistered(input).then(result => {
    if (result == '0') {
      idResult = true;
      idResultArea.innerHTML = '<span class="text-success">사용가능한 아이디입니다.</span>';
    } else {
      idResult = false;
      idResultArea.innerHTML = '<span class="text-danger">이미 사용중인 아이디입니다.</span>'
    }
  }).catch(console.log);
});

async function isRegistered(id) {
  try {
    const response = await fetch(`/user/check/${id}`);
    const result = await response.text();
    return result;
  } catch (error) {
    console.log(error);
  }
}

// 비밀번호 확인
function validate() {
  const [input, match] = [pw, pwCheck].map(e => e.value);
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
  pwValidationArea.innerHTML = `<span class="${pwValid ? 'text-success' : 'text-danger'}">${msgVal}</span>`;

  pwMatch = input == match;
  pwMatchArea.innerHTML = pwMatch ? '' : '<span class="text-danger">비밀번호가 맞지 않습니다.</span>';
}

pw.onchange = validate;
pwCheck.onchange = validate;

// 최종 제출
registerBtn.onclick = () => {
  if (idResult == undefined) {
    idResultArea.innerHTML = '<span>아이디 중복 확인을 해주세요.</span>';
    idCheckBtn.focus();
    return;
  }

  if (!idResult) idCheckBtn.focus();
  else if (!pwValid) pw.focus();
  else if (!pwMatch) pwCheck.focus();
  else if (nick.value == '') nick.focus();
  else document.getElementById('registerForm').submit();
};