/**
 * 
 */
//좋아요, 싫어요
const [likeIcon, likeCount, dislikeIcon, dislikeCount, likeArea, dislikeArea] = ['likeIcon', 'likeCount', 'dislikeIcon', 'dislikeCount', 'likeArea', 'dislikeArea'].map(e => document.getElementById(e));
if (id != '') {
  likeArea.classList.add('btn');
  dislikeArea.classList.add('btn');
}

function formed(num) {
  return num > 999 ? '999+' : num;
}

function flushLike() {
  getLikeCount();
  if (id != '') getLike();
}
async function getLikeCount() {
  try {
    const resp = await fetch('/board/getLikeCount?bno=' + bno);
    const result = await resp.text();
    likeCount.innerText = formed(result);
  } catch (error) {
    console.log(error);
  }
}
async function getLike() {
  try {
    const resp = await fetch(`/board/getLike?bno=${bno}&id=${id}`);
    const result = await resp.text();
    console.log('like', result);
    likeIcon.innerHTML = result === '0' ? `
    <svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" fill="currentColor" class="bi bi-hand-thumbs-up" viewBox="0 0 16 16">
      <path d="M8.864.046C7.908-.193 7.02.53 6.956 1.466c-.072 1.051-.23 2.016-.428 2.59-.125.36-.479 1.013-1.04 1.639-.557.623-1.282 1.178-2.131 1.41C2.685 7.288 2 7.87 2 8.72v4.001c0 .845.682 1.464 1.448 1.545 1.07.114 1.564.415 2.068.723l.048.03c.272.165.578.348.97.484.397.136.861.217 1.466.217h3.5c.937 0 1.599-.477 1.934-1.064a1.86 1.86 0 0 0 .254-.912c0-.152-.023-.312-.077-.464.201-.263.38-.578.488-.901.11-.33.172-.762.004-1.149.069-.13.12-.269.159-.403.077-.27.113-.568.113-.857 0-.288-.036-.585-.113-.856a2 2 0 0 0-.138-.362 1.9 1.9 0 0 0 .234-1.734c-.206-.592-.682-1.1-1.2-1.272-.847-.282-1.803-.276-2.516-.211a10 10 0 0 0-.443.05 9.4 9.4 0 0 0-.062-4.509A1.38 1.38 0 0 0 9.125.111zM11.5 14.721H8c-.51 0-.863-.069-1.14-.164-.281-.097-.506-.228-.776-.393l-.04-.024c-.555-.339-1.198-.731-2.49-.868-.333-.036-.554-.29-.554-.55V8.72c0-.254.226-.543.62-.65 1.095-.3 1.977-.996 2.614-1.708.635-.71 1.064-1.475 1.238-1.978.243-.7.407-1.768.482-2.85.025-.362.36-.594.667-.518l.262.066c.16.04.258.143.288.255a8.34 8.34 0 0 1-.145 4.725.5.5 0 0 0 .595.644l.003-.001.014-.003.058-.014a9 9 0 0 1 1.036-.157c.663-.06 1.457-.054 2.11.164.175.058.45.3.57.65.107.308.087.67-.266 1.022l-.353.353.353.354c.043.043.105.141.154.315.048.167.075.37.075.581 0 .212-.027.414-.075.582-.05.174-.111.272-.154.315l-.353.353.353.354c.047.047.109.177.005.488a2.2 2.2 0 0 1-.505.805l-.353.353.353.354c.006.005.041.05.041.17a.9.9 0 0 1-.121.416c-.165.288-.503.56-1.066.56z"/>
    </svg>` : `<svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" fill="currentColor" class="bi bi-hand-thumbs-up-fill" viewBox="0 0 16 16">
      <path d="M6.956 1.745C7.021.81 7.908.087 8.864.325l.261.066c.463.116.874.456 1.012.965.22.816.533 2.511.062 4.51a10 10 0 0 1 .443-.051c.713-.065 1.669-.072 2.516.21.518.173.994.681 1.2 1.273.184.532.16 1.162-.234 1.733q.086.18.138.363c.077.27.113.567.113.856s-.036.586-.113.856c-.039.135-.09.273-.16.404.169.387.107.819-.003 1.148a3.2 3.2 0 0 1-.488.901c.054.152.076.312.076.465 0 .305-.089.625-.253.912C13.1 15.522 12.437 16 11.5 16H8c-.605 0-1.07-.081-1.466-.218a4.8 4.8 0 0 1-.97-.484l-.048-.03c-.504-.307-.999-.609-2.068-.722C2.682 14.464 2 13.846 2 13V9c0-.85.685-1.432 1.357-1.615.849-.232 1.574-.787 2.132-1.41.56-.627.914-1.28 1.039-1.639.199-.575.356-1.539.428-2.59z"/>
    </svg>`;
  } catch (error) {
    console.log(error);
  }
}

function flushDislike() {
  getDislikeCount();
  if (id != '') getDislike();
}
async function getDislikeCount() {
  try {
    const resp = await fetch('/board/getDislikeCount?bno=' + bno);
    const result = await resp.text();
    dislikeCount.innerText = formed(Number(result));
  } catch (error) {
    console.log(error);
  }
}

async function getDislike() {
  try {
    const resp = await fetch(`/board/getDislike?bno=${bno}&id=${id}`)
    const result = await resp.text();
    console.log('dislike', result);
    dislikeIcon.innerHTML = result === '0' ? `
    <svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" fill="currentColor" class="bi bi-hand-thumbs-down" viewBox="0 0 16 16">
      <path d="M8.864 15.674c-.956.24-1.843-.484-1.908-1.42-.072-1.05-.23-2.015-.428-2.59-.125-.36-.479-1.012-1.04-1.638-.557-.624-1.282-1.179-2.131-1.41C2.685 8.432 2 7.85 2 7V3c0-.845.682-1.464 1.448-1.546 1.07-.113 1.564-.415 2.068-.723l.048-.029c.272-.166.578-.349.97-.484C6.931.08 7.395 0 8 0h3.5c.937 0 1.599.478 1.934 1.064.164.287.254.607.254.913 0 .152-.023.312-.077.464.201.262.38.577.488.9.11.33.172.762.004 1.15.069.13.12.268.159.403.077.27.113.567.113.856s-.036.586-.113.856c-.035.12-.08.244-.138.363.394.571.418 1.2.234 1.733-.206.592-.682 1.1-1.2 1.272-.847.283-1.803.276-2.516.211a10 10 0 0 1-.443-.05 9.36 9.36 0 0 1-.062 4.51c-.138.508-.55.848-1.012.964zM11.5 1H8c-.51 0-.863.068-1.14.163-.281.097-.506.229-.776.393l-.04.025c-.555.338-1.198.73-2.49.868-.333.035-.554.29-.554.55V7c0 .255.226.543.62.65 1.095.3 1.977.997 2.614 1.709.635.71 1.064 1.475 1.238 1.977.243.7.407 1.768.482 2.85.025.362.36.595.667.518l.262-.065c.16-.04.258-.144.288-.255a8.34 8.34 0 0 0-.145-4.726.5.5 0 0 1 .595-.643h.003l.014.004.058.013a9 9 0 0 0 1.036.157c.663.06 1.457.054 2.11-.163.175-.059.45-.301.57-.651.107-.308.087-.67-.266-1.021L12.793 7l.353-.354c.043-.042.105-.14.154-.315.048-.167.075-.37.075-.581s-.027-.414-.075-.581c-.05-.174-.111-.273-.154-.315l-.353-.354.353-.354c.047-.047.109-.176.005-.488a2.2 2.2 0 0 0-.505-.804l-.353-.354.353-.354c.006-.005.041-.05.041-.17a.9.9 0 0 0-.121-.415C12.4 1.272 12.063 1 11.5 1"/>
    </svg>`: `
    <svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" fill="currentColor" class="bi bi-hand-thumbs-down-fill" viewBox="0 0 16 16">
      <path d="M6.956 14.534c.065.936.952 1.659 1.908 1.42l.261-.065a1.38 1.38 0 0 0 1.012-.965c.22-.816.533-2.512.062-4.51q.205.03.443.051c.713.065 1.669.071 2.516-.211.518-.173.994-.68 1.2-1.272a1.9 1.9 0 0 0-.234-1.734c.058-.118.103-.242.138-.362.077-.27.113-.568.113-.856 0-.29-.036-.586-.113-.857a2 2 0 0 0-.16-.403c.169-.387.107-.82-.003-1.149a3.2 3.2 0 0 0-.488-.9c.054-.153.076-.313.076-.465a1.86 1.86 0 0 0-.253-.912C13.1.757 12.437.28 11.5.28H8c-.605 0-1.07.08-1.466.217a4.8 4.8 0 0 0-.97.485l-.048.029c-.504.308-.999.61-2.068.723C2.682 1.815 2 2.434 2 3.279v4c0 .851.685 1.433 1.357 1.616.849.232 1.574.787 2.132 1.41.56.626.914 1.28 1.039 1.638.199.575.356 1.54.428 2.591"/>
    </svg>`;
  } catch (error) {
    console.log(error);
  }
}

flushLike();
flushDislike();

async function toggleLike() {
  if (id == '') return;

  fetch(`/board/toggleLike?id=${id}&bno=${bno}`)
    .then(resp => resp.text())
    .then(result => {
      if (result === '0') return;

      liked = result === '1';
      flushLike();
    }).catch(console.log);
}

async function toggleDislike() {
  if (id == '') return;

  fetch(`/board/toggleDislike?id=${id}&bno=${bno}`)
    .then(resp => resp.text())
    .then(result => {
      if (result === '0') return;

      disliked = result === '1';
      flushDislike();
    }).catch(console.log);
}

likeArea.onclick = toggleLike;
dislikeArea.onclick = toggleDislike;

// 북마크
const bookmarkArea = document.getElementById('bookmarkArea');
let bookmarked = false;

async function flushBookmark() {
  if (id == '') return;

  fetch(`/board/getBookmark?id=${id}&bno=${bno}`)
    .then(resp => resp.text())
    .then(result => {
      bookmarkArea.innerHTML = result === '0' ? `
    <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor" class="bi bi-bookmark" viewBox="0 0 16 16">
      <path d="M2 2a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v13.5a.5.5 0 0 1-.777.416L8 13.101l-5.223 2.815A.5.5 0 0 1 2 15.5zm2-1a1 1 0 0 0-1 1v12.566l4.723-2.482a.5.5 0 0 1 .554 0L13 14.566V2a1 1 0 0 0-1-1z"/>
    </svg>
    ` : `
    <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor" class="bi bi-bookmark-check" viewBox="0 0 16 16">
      <path fill-rule="evenodd" d="M10.854 5.146a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 1 1 .708-.708L7.5 7.793l2.646-2.647a.5.5 0 0 1 .708 0"/>
      <path d="M2 2a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v13.5a.5.5 0 0 1-.777.416L8 13.101l-5.223 2.815A.5.5 0 0 1 2 15.5zm2-1a1 1 0 0 0-1 1v12.566l4.723-2.482a.5.5 0 0 1 .554 0L13 14.566V2a1 1 0 0 0-1-1z"/>
    </svg>
    `;
    });
}

async function toggleBookmark() {
  if (id == '') return;

  fetch(`/board/toggleBookmark?id=${id}&bno=${bno}`)
    .then(resp => resp.text())
    .then(result => {
      bookmarked = result === '1';
      flushBookmark();
    })
}

if (id != '') {
  bookmarkArea.onclick = toggleBookmark;
  flushBookmark();
}

// 댓글 등록
const [cname, pwd, cid, content, cmtCancelBtn, cmtRegisterBtn] = ['cname', 'pwd', 'cid', 'content', 'cmtCancelBtn', 'cmtRegisterBtn'].map(e => document.getElementById(e));

cmtCancelBtn.addEventListener('click', () => {
  content.value = '';
  try {
    pwd.value = '';
    cid.value = '';
  } catch (error) {
    ;
  }
});

cmtRegisterBtn.addEventListener('click', () => {
  if (pwd != null) {
    if (cname.value == '') {
      cname.focus();
      return;
    }
    if (pwd.value == '') {
      pwd.focus();
      return;
    }
  }

  if (content.value == '') {
    content.focus();
    return;
  }

  let json = {
    'bno': bno,
    'name': cname.value,
    'content': content.value
  };
  if (pwd != null) json['pwd'] = pwd.value;
  else json['id'] = cid.value;

  fetch('/comment/register', {
    method: 'post',
    headers: {
      'Content-Type': 'application/json; charset=utf-8'
    },
    body: JSON.stringify(json)
  })
    .then(resp => resp.text())
    .then(result => {
      if (result == '0') {
        alert('댓글 등록에 실패했습니다. 다시 시도해주세요.');
        return;
      }

      cmtCancelBtn.click();
      flushComment();
    })
    .catch(console.log)
});

// 댓글 불러오기
const cmtListArea = document.getElementById("commentListArea");
function flushComment() {
  fetch('/comment/list?bno=' + bno)
    .then(resp => resp.json())
    .then(json => {
      let init = '<div class="row mb-3">';
      init += '<div class="col-2 d-flex justify-content-center align-items-center">작성자</div>';
      init += '<div class="col-6 d-flex justify-content-center align-items-center">내용</div>';
      init += '<div  class="col-2 d-flex justify-content-center align-items-center">작성일</div>';
      init += '</div><hr>';
      cmtListArea.innerHTML = init;
      for (const cvo of json) {
        const modifiable = cvo.id == null || cvo.id == id;
        const removable = modifiable || isManager;
        let cmt = `
        <div class="row mb-3" data-cno=${cvo.cno}>`;
        cmt += `
          <div class="col-2 d-flex justify-content-center align-items-center">
            <div class="cmtName">${cvo.name}</div>`;
        if (cvo.id == null)
          cmt += `
            <div class="cmtPwdInput d-none">
              <div class="w-25 d-flex align-items-center">비밀번호</div>
              <div class="w-75"><input type="password" class="form-control cmtNameInput"></div>
            </div>`;
        cmt += `
          </div>`;
        cmt += `
          <div class="col-6 d-flex align-items-center cmtContent">${cvo.content}</div>`;
        cmt += `
          <div class="col-6 d-none align-items-center cmtContentInput">
            <input type="text" class="form-control" data-cno=${cvo.cno} value=${cvo.content} />
          </div>`;
        cmt += `
          <div class="col-2 d-flex justify-content-center align-items-center">${cvo.regDate}</div>`;
        cmt += `
          <div class="col-2 d-flex justify-content-end">`;
        if (modifiable) {
          cmt += `
            <button type="button" data-cno=${cvo.cno}
              class="btn btn-warning me-3 modifyBtn ${cvo.id == null ? 'anonymous' : ''}">수정</button>`;
          cmt += `
            <button type="button" data-cno=${cvo.cno}
              class="btn btn-warning me-3 updateBtn d-none ${cvo.id == null ? 'anonymous' : ''}">확인</button>`;
        }
        if (removable) cmt += `
            <button type="button" data-cno=${cvo.cno}
              class="btn btn-danger removeBtn ${cvo.id == null ? 'anonymous' : ''}">삭제</button>`;
        cmt += `
          </div>
        </div>`;
        cmtListArea.innerHTML += cmt;
      }
    }).catch(console.log);
}

flushComment();

document.addEventListener('click', e => {
  const classList = e.target.classList;
  const cno = e.target.dataset.cno;

  if (classList.contains('modifyBtn')) {
    const cmtArea = e.target.closest('.row');
    
    hide(cmtArea.querySelector('.cmtContent'));
    show(cmtArea.querySelector('.cmtContentInput'));
    hide(cmtArea.querySelector('.modifyBtn'));
    show(cmtArea.querySelector('.updateBtn'));

    if (classList.contains('anonymous')) {
      show(cmtArea.querySelector('.cmtPwdInput'));
    }
  } else if (classList.contains('removeBtn') && confirm('댓글을 삭제하시겠습니까?')) {
    if (classList.contains('anonymous')) {
      const pwdInput = prompt('비밀번호를 입력하세요.');
      fetch('/comment/remove', {
        method: 'post',
        headers: {
          'Content-Type': 'application/json; charset=utf-8'
        },
        body: JSON.stringify({
          cno: cno,
          pwd: pwdInput
        })
      }).then(resp => resp.text())
        .then(result => {
          if (result == '-1') alert('비밀번호가 틀렸습니다.');
          else if (result == '0') alert('오류가 발생했습니다. 다시 시도해주세요.');
          else flushComment();
        }).catch(error => {
          console.log(error);
          alert('오류가 발생했습니다.');
        });
    } else {
      fetch('/comment/remove?cno=' + cno)
        .then(resp => resp.text())
        .then(result => {
          if (result == '0') alert('댓글을 삭제하지 못했습니다.');
          else flushComment();
        })
    }
  } else if (classList.contains('updateBtn')) {
    const cmtArea = e.target.closest('.row');
    let json = {
      cno: cmtArea.dataset.cno,
      content: cmtArea.querySelector('.cmtContentInput input').value
    };
    const pwdInput = cmtArea.querySelector('.cmtPwdInput input');
    if (pwdInput != null) json['pwd'] = pwdInput.value;

    fetch('/comment/update', {
      method: 'post',
      headers: {
        'Content-Type': 'application/json; charset=utf-8'
      },
      body: JSON.stringify(json)
    }).then(resp => resp.text())
    .then(result => {
      if (result == '-1') alert('비밀번호가 틀렸습니다.');
      else if (result == '0') alert('댓글 수정에 실패했습니다.');
      else {
        if(classList.contains('anonymous')) hide(cmtArea.querySelector('.cmtPwdInput'));
        cmtArea.querySelector('.cmtContent').innerText = cmtArea.querySelector('.cmtContentInput input').value;
        hide(cmtArea.querySelector('.cmtContentInput'));
        show(cmtArea.querySelector('.cmtContent'));
        hide(e.target);
        show(cmtArea.querySelector('.modifyBtn'));
      }
      
    })
  }
});

function hide(e) {
  e.classList.remove("d-flex");
  e.classList.add('d-none');
}
function show(e) {
  e.classList.remove('d-none');
  e.classList.add('d-flex');
}