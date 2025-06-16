/**
 * 
 */
const [nickPrint, emailPrint, defaultBtnArea, infoModifyBtn, infoUpdateBtnArea, cancelBtn, updateBtn] = ['nickPrint', 'emailPrint', 'defaultBtnArea', 'infoModifyBtn', 'infoUpdateBtnArea', 'cancelBtn', 'updateBtn'].map(e => document.getElementById(e));
const [nickInputArea, nickInput, emailInputArea, emailInput] = ['nickInputArea', 'nickInput', 'emailInputArea', 'emailInput'].map(e => document.getElementById(e));
infoModifyBtn.addEventListener('click', () => {
  hide(nickPrint);
  hide(emailPrint);
  hide(defaultBtnArea);
  show(nickInputArea);
  show(emailInputArea);
  show(infoUpdateBtnArea);
});

updateBtn.addEventListener('click', () => {
  if (nickInput.value == '') {
    nickInput.focus();
    return;
  }

  fetch('/user/update', {
    method: 'post',
    headers: {
      'Content-Type': 'application/json; charset=utf-8'
    },
    body: JSON.stringify({
      'id': id,
      'name': nickInput.value,
      'email': emailInput.value
    })
  }).then(resp => resp.text())
    .then(result => {
      if (result === '0') {
        alert('수정에 실패했습니다. 다시 시도해주세요.');
        return;
      }
      nickPrint.innerText = nickInput.value;
      emailPrint.innerText = emailInput.value == '' ? '-' : emailInput.value;
      
      cancelBtn.click();
    })
    .catch(error => {
      console.log(error);
      alert('오류가 발생했습니다.');
    })
});

cancelBtn.addEventListener('click', () => {
  hide(nickInputArea);
  hide(emailInputArea);
  hide(infoUpdateBtnArea);
  show(nickPrint);
  show(emailPrint);
  show(defaultBtnArea);
});

function hide(item) {
  item.classList.remove('d-flex');
  item.classList.add('d-none');
}
function show(item) {
  item.classList.remove('d-none');
  item.classList.add('d-flex');
}