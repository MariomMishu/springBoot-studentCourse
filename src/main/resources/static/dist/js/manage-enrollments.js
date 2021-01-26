var userId;
$(document).ready(function () {
    $.ajax({
        url: '/enrollment/ajaxGetAll',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        success: function (resp) {

            $.each(resp, function (i, item) {
                var row = `<tr>
                            <td>${item.id}</td>
                                 <td>${item.student.name}</td>
                                 <td>${item.sessionTrimester.name}</td>
                                 <td>
                                 <button type="submit"class="btn btn-success" data-dismiss="modal" onclick="edit(${item.id})">Edit</button>
                                 <button type="submit"class="btn btn-danger" data-dismiss="modal" onclick="delete(${item.id})">Delete</button>
                                  </td>
                        </tr>`;
                $(".table-body").append(row);
            });
        },
        error: function (err) {
            console.log(err);
        }
    });

    $(".form").on('submit', function (e) {
        e.preventDefault();
        var data = JSON.stringify($(this).serializeObject());
        var url = '/enrollment/ajaxAdd';

        $.ajax({
            data: data,
            url: url,
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            success: function (resp) {
                var row = `<tr>
                                <td>${item.id}</td>
                                 <td>${item.student.name}</td>
                                 <td>${item.sessionTrimester.name}</td>
                                 <td>
                                 <button type="submit"class="btn btn-success" data-dismiss="modal" onclick="edit(${item.id})">Edit</button>
                                 <button type="submit"class="btn btn-danger" data-dismiss="modal" onclick="delete(${item.id})">Delete</button>
                                  </td>
                                 </tr>`;
                $(".table-body").append(row);
                $("input").val("");
            },
            error: function (err) {
                console.log(err);
            }
        });
    });


    

    $.fn.serializeObject = function () {
        var o = {};
        var a = this.serializeArray();
        $.each(a, function () {
            if (o[this.name] !== undefined) {
                if (!o[this.name].push) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value || '');
            } else {
                o[this.name] = this.value || '';
            }
        });
        return o;
    };
});
