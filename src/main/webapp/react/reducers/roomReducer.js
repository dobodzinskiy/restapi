import * as types from '../actions/actionTypes';

const initialState = {
    rooms: [],
    room: [],
    order: []
};

export default function (state = initialState, action) {
    switch (action.type) {
        case types.GET_ROOMS:
            return Object.assign({}, state, {
                rooms: action.rooms
            });
        case types.GET_ROOM:
            return Object.assign({}, state, {
                room: action.room
            });
        case types.POST_ORDER:
            return Object.assign({}, state, {
                order: action.order
            });
        default:
            return state;
    }
}