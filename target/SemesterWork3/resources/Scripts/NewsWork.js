/**
 * Created by unlim_000 on 02.06.2016.
 */
function addComment(id, form) {
    var formCont = form.textComment.value();
    $.ajax({
        url: "/addComment",
        type: "POST",
        data: {
            postID: id,
            text: formCont
        },
        success: function () {
            alert('Комментарий добавлен ууспешно');
            return true;
        }
    })
}