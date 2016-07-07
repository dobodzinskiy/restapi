import React from 'react';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import * as roomActions from '../../actions/roomActions';

import RoomsPanel from '../view/rooms';

function mapStateToProps(store) {
    return {
        roomState : store.roomState
    };
}
function mapDispatchToProps(dispatch) {
    return bindActionCreators(roomActions, dispatch);
}
export default connect(mapStateToProps, mapDispatchToProps)(RoomsPanel);
