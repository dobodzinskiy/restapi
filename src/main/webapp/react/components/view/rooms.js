import React from 'react';
import $ from 'jquery';
import { hashHistory } from 'react-router';
import { Panel, ListGroup, ListGroupItem, OverlayTrigger, Popover } from 'react-bootstrap';

class Room extends React.Component {
    render() {
        var { room } = this.props;
        var tv, conditioner, balcony, pool, slides, tennis;
        tv = room.tv == 'on' ? <span class="glyphicon glyphicon-ok"/> : <span class="glyphicon glyphicon-remove"/>;
        conditioner = room.conditioner == 'on' ? <span class="glyphicon glyphicon-ok"/> :
            <span class="glyphicon glyphicon-remove"/>;
        balcony = room.balcony == 'on' ? <span class="glyphicon glyphicon-ok"/> :
            <span class="glyphicon glyphicon-remove"/>;
        pool = room.pool == 'on' ? <span class="glyphicon glyphicon-ok"/> :
            <span class="glyphicon glyphicon-remove"/>;
        slides = room.slides == 'on' ? <span class="glyphicon glyphicon-ok"/> :
            <span class="glyphicon glyphicon-remove"/>;
        tennis = room.tennis == 'on' ? <span class="glyphicon glyphicon-ok"/> :
            <span class="glyphicon glyphicon-remove"/>;
        return (
            <tr>
                <td>{room.number}</td>
                <OverlayTrigger trigger="hover" placement="bottom"
                                overlay={
                                <Popover title={room.hotelName}>
                                    <table>
                                        <tr>
                                            <td>Pool:</td>
                                            <td>{pool}</td>
                                        </tr>
                                        <tr>
                                            <td>Slides:</td>
                                            <td>{slides}</td>
                                        </tr>
                                        <tr>
                                            <td>Tennis courts:</td>
                                            <td>{tennis}</td>
                                        </tr>
                                    </table>
                                </Popover>}>
                    <td>{room.hotelName}</td>
                </OverlayTrigger>
                <td>{room.roomType}</td>
                <td>{tv}</td>
                <td>{balcony}</td>
                <td>{conditioner}</td>
                <td>
                    <a href={"#/order/" + room.id} class="btn btn-primary">Book!</a>
                </td>
            </tr>
        )
    }
}


class RoomsPanel extends React.Component {
    componentDidMount() {
        this.props.getRooms(this.props.location.query);
    }

    onChange() {
        var filter = $("#filter").serialize();
        this.props.getRooms(filter);
        hashHistory.replace('/?' + filter);
    }

    render() {
        var { rooms } = this.props.roomState;
        return (
            <div>
                <h3>Free rooms:</h3>
                <div class="col-sm-3">
                    <form id="filter" onChange={() => {this.onChange();}}>
                        <Panel collapsible defaultExpanded header="Filters :">
                            <ListGroup fill>
                                <ListGroupItem>
                                    <div class="checkbox">
                                        <label><input name="b" type="checkbox"/> Balcony</label>
                                    </div>
                                </ListGroupItem>
                                <ListGroupItem>
                                    <div class="checkbox">
                                        <label><input name="c" type="checkbox"/> Conditioner</label>
                                    </div>
                                </ListGroupItem>
                                <ListGroupItem>
                                    <div class="checkbox">
                                        <label><input name="tv" type="checkbox"/> TV</label>
                                    </div>
                                </ListGroupItem>
                                <ListGroupItem>
                                    <div class="checkbox">
                                        <label><input name="p" type="checkbox"/> Pool</label>
                                    </div>
                                </ListGroupItem>
                                <ListGroupItem>
                                    <div class="checkbox">
                                        <label><input name="s" type="checkbox"/> Slides</label>
                                    </div>
                                </ListGroupItem>
                                <ListGroupItem>
                                    <div class="checkbox">
                                        <label><input name="t" type="checkbox"/> Tennis court</label>
                                    </div>
                                </ListGroupItem>
                                <ListGroupItem>
                                    <div class="form-group">
                                        <label for="rType">Room type:</label>
                                        <select name="rType" class="form-control">
                                            <option selected value="Any"> -- select an option -- </option>
                                            <option>Single</option>
                                            <option>Double</option>
                                            <option>Twin</option>
                                        </select>
                                    </div>
                                </ListGroupItem>
                                <ListGroupItem>
                                    <div class="form-group">
                                        <label for="rView">Room view:</label>
                                        <select name="rView" class="form-control">
                                            <option selected value="Any"> -- select an option -- </option>
                                            <option>Garbage</option>
                                            <option>Pool</option>
                                            <option>Sea</option>
                                        </select>
                                    </div>
                                </ListGroupItem>
                                <ListGroupItem>
                                    <div class="form-group">
                                        <label for="hType">Hotel type:</label>
                                        <select name="hType" class="form-control">
                                            <option selected value="Any"> -- select an option -- </option>
                                            <option>Check in</option>
                                            <option>Daily</option>
                                        </select>
                                    </div>
                                </ListGroupItem>
                            </ListGroup>
                        </Panel>
                    </form>
                </div>
                <div class="col-sm-9">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Hotel</th>
                            <th>Type</th>
                            <th>TV</th>
                            <th>Balcony</th>
                            <th>Conditioner</th>
                            <th>Order</th>
                        </tr>
                        </thead>
                        <tbody>
                        {rooms.map((room) => {
                            return (
                                <Room room={room} key={room.id} />
                            )
                        })}
                        </tbody>
                    </table>

                </div>
            </div>
        )
    }
}

export default RoomsPanel;
