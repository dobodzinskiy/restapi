import roomReducer from './roomReducer';
import { combineReducers } from 'redux';

module.exports = combineReducers({
    roomState: roomReducer
});