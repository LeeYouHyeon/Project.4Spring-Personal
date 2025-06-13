/**
 * 
 */

const [id, nick, title, content, button] = ["id", 'name', 'title', 'content', 'button'].map(e => document.getElementById(e));

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
    if (result === '0') alert('등록에 실패했습니다. 다시 시도해주세요.');
    else location.href = '/board/detail?bno=' + result;
  })
});

async function register() {
  const json = {
    title: title.value,
    id: id.value,
    name: nick.value,
    content: content.value
  };
  console.log(json);
  try {
    const response = await fetch('/board/register', {
      method: 'post',
      headers: {
        'Content-Type': 'application/json; charset=utf-8'
      },
      body: JSON.stringify(json)
    });
    const result = await response.text();
    return result;
  } catch (error) {
    console.log(error);
  }
}