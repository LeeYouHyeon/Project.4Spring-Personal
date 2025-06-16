/**
 * 
 */
// 이전글
const domParser = new DOMParser();
fetch('/notice/getBefore?nno=' + nno)
  .then(resp => resp.text())
  .then(text => domParser.parseFromString(text, "application/xml"))
  .then(xml => {
    try {
      const [beforeTitle, beforeRegDate] = ['beforeTitle', 'beforeRegDate'].map(e => document.getElementById(e));
      const [bNno, bTitle, bRegDate] = ["nno", "title", "regDate"].map(e => xml.getElementsByTagName(e)[0].textContent);

      beforeTitle.innerHTML = `<a href="/notice/detail?nno=${bNno}">${bTitle}</a>`;
      beforeRegDate.innerText = bRegDate;
    } catch (error) {
      document.getElementById('beforeArea').innerHTML = '<div class="col text-center">이전 글이 없습니다.</div>';
    }
  }).catch(error => {
    console.log(error);
    document.getElementById('beforeArea').innerHTML = '<div class="col text-center">이전 글을 불러오는 중에 오류가 발생했습니다.</div>';
  });

// 다음글
fetch('/notice/getNext?bno=' + nno)
  .then(resp => resp.text())
  .then(text => domParser.parseFromString(text, "application/xml"))
  .then(xml => {
    try {
      const [nextTitle, nextRegDate] = ['nextTitle', 'nextRegDate'].map(e => document.getElementById(e));
      const [nNno, nTitle, nRegDate] = ["bno", "title", "regDate"].map(e => xml.getElementsByTagName(e)[0].textContent);
  
      nextTitle.innerHTML = `<a href="/notice/detail?nno=${nNno}">${nTitle}</a>`;
      nextRegDate.innerText = nRegDate;
    } catch (error) {
      document.getElementById('nextArea').innerHTML = '<div class="col text-center">다음 글이 없습니다.</div>';  
    }
  }).catch(error => {
    console.log(error);
    document.getElementById('nextArea').innerHTML = '<div class="col text-center">다음 글을 불러오는 중에 오류가 발생했습니다.</div>';
  });