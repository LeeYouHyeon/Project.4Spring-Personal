/**
 * 
 */
const [title, content, button] = ['title', 'content', 'button'].map(e => document.getElementById(e));

button.addEventListener('click', () => {
  if (title.value == '') {
    id.focus();
    return;
  }
  if (content.value == '') {
    content.focus();
    return;
  }

  register().then(result => {
    if (result === '0') alert('수정에 실패했습니다. 다시 시도해주세요.');
    else location.href = `/board/detail?update=true&bno=${bno}&update=true`;
  })
});

async function register() {
  try {
    const response = await fetch('/board/update', {
      method: 'post',
      headers: {
        'Content-Type': 'application/json; charset=utf-8'
      },
      body: JSON.stringify({
        bno: bno,
        title: title.value,
        name: nick,
        content: content.value
      })
    });
    const result = await response.text();
    return result;
  } catch (error) {
    console.log(error);
  }
}