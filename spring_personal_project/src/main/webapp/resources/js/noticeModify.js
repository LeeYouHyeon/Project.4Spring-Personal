/**
 * 
 */
const [title, content, expDateBtn, expDate, submitBtn] = ['title', 'content', 'expDateBtn', 'expDate', 'submitBtn'].map(e => document.getElementById(e));

expDateBtn.addEventListener('click', () => {
  expDate.disabled = !expDateBtn.checked;
})

submitBtn.addEventListener('click', () => {
  let json = {
    'nno': nno,
    'title': title.value,
    'content': content.value
  };
  if (!expDate.disabled) json['expDate'] = expDate.value;

  fetch('/notice/update', {
    method: 'post',
    headers: {
      'Content-Type': 'application/json; charset=utf-8'
    },
    body: JSON.stringify(json)
  }).then(resp => resp.text())
  .then(result => {
    if (result === '0') alert('수정에 실패했습니다. 다시 시도해주세요.');
    else location.href = `/notice/detail?nno=${nno}&update=true`;
  }).catch(console.log);
});