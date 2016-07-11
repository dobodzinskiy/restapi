import $ from 'jquery';

export function getRooms(filter) {
    return new Promise((resolve,reject) => {
        $.ajax({
            url: '/rest/v1.0/rooms',
            data: filter,
            type: 'GET',
            headers: {
                "accept": "application/json",
                "content-type": "application/json",
                "authorization": "Basic Y2xpZW50OnBhc3N3b3Jk",
                "cache-control": "no-cache"
            },
            success: function(data) {
                resolve(data)
            },
            error: function(xhr) {
                reject(JSON.parse(xhr.responseText));
            }
        })
    })
}
export function getRoom(id) {
    return new Promise((resolve,reject) => {
        $.ajax({
            url: '/rest/v1.0/rooms/' + id,
            type: 'GET',
            headers: {
                "accept": "application/json",
                "content-type": "application/json",
                "authorization": "Basic Y2xpZW50OnBhc3N3b3Jk",
                "cache-control": "no-cache"
            },
            success: function(data) {
                resolve(data)
            },
            error: function(xhr) {
                reject(JSON.parse(xhr.responseText));
            }
        })
    })
}
export function order(order) {
    return new Promise((resolve, reject) => {
        $.ajax({
            url: '/rest/v1.0/orders',
            type: 'POST',
            data: JSON.stringify(order),
            headers: {
                "accept": "application/json",
                "content-type": "application/json",
                "authorization": "Basic Y2xpZW50OnBhc3N3b3Jk",
                "cache-control": "no-cache"
            },
            success: function(data) {
                resolve(data)
            },
            error: function(xhr) {
                reject(JSON.parse(xhr.responseText))
            }
        })
    })
}
