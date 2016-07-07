import $ from 'jquery';

export function getRooms(filter) {
    return new Promise((resolve,reject) => {
        $.ajax({
            url: '/rest/v1.0/rooms',
            data: filter,
            type: 'GET',
            "headers": {
                "content-type": "application/json",
                "authorization": "Basic Y2xpZW50OnBhc3N3b3Jk",
                "cache-control": "no-cache"
            },
            "processData": false,
            success: function(data) {
                resolve(data)
            },
            error: function(xhr) {
                reject(JSON.parse(xhr.responseText));
            }
        })
    })
}
