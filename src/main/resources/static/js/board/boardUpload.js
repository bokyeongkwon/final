'use strict';
//textArea => ck_editor 대체
ClassicEditor
      .create( document.querySelector( '#boardContent' ), {
       plugin:['ListStyle','Markdown','MediaEmbed','MediaEmbedToolbar'],
         toolbar: {
            items: [
               'heading',
               '|',
               'underline',
               'bold',
               'italic',
               'link',
               'bulletedList',
               'numberedList',
               'todoList',
               '|',
               'outdent',
               'indent',
               '|',
               'imageInsert',
               'imageUpload',
               'blockQuote',
               'insertTable',
               'mediaEmbed',
               'markdown',
               'undo',
               'redo',
               '|',
               'highlight',
               'fontFamily',
               'fontColor',
               'fontBackgroundColor',
               'fontSize',
               '|',
               'htmlEmbed',
               'specialCharacters'
            ]
         },
         language: 'en',
         image: {
            toolbar: [
               'imageTextAlternative',
               'imageStyle:full',
               'imageStyle:side'
            ]
         },
         table: {
            contentToolbar: [
               'tableColumn',
               'tableRow',
               'mergeTableCells',
               'tableCellProperties',
               'tableProperties'
            ]
         },
      })
      .then( editor => {

         window.editor = editor;
      } )
      .catch( error => {
         console.error( error );
      } );
const $main = document.querySelector('main');
const $cateNum = ($main?.dataset.cateNum) ? $main.dataset.cateNum : '';


//등록
const $upLoad = document.getElementById('upLoad');
$upLoad?.addEventListener("click", e=>{
  addForm.submit();
});
//목록
const $listBtn = document.getElementById('listBtn');
$listBtn?.addEventListener("click",e=>{
  const url = `/board/list?category=${cateNum}`;
  location.href = url;
});
//분류자동 선택
const $options = document.querySelectorAll('#cateNum');
[...$options].find(option=>option.value===cateNum).setAttribute('selected','selected');


