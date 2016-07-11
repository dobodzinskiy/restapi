import * as api from '../api/roomApi';
import * as types from './actionTypes';
import { hashHistory } from 'react-router';

export function getRooms(filter) {
    return function (dispatch) {
        return api.getRooms(filter).then(
            data => dispatch({
                type: types.GET_ROOMS,
                rooms: data
            }),
            error => alert(error)
        )
    }
}
export function getRoom(id) {
    return function (dispatch) {
        return api.getRoom(id).then(
            data => dispatch({
                type: types.GET_ROOM,
                room: data
            }),
            error => alert(error)
        )
    }
}
export function order(order) {
    return function (dispatch) {
        return api.order(order).then(
            data => dispatch({
                type: types.POST_ORDER,
                order: data
            }),
            error => alert(error)
        )
    }
}
