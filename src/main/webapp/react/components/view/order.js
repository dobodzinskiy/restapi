import React from 'react';
import $ from 'jquery';
import { hashHistory } from 'react-router';

class Order extends React.Component {
    componentDidMount() {
        this.props.getRoom(this.props.params.id);
    }

    order() {
        var { room } = this.props.roomState;
        var order = {
            hotelName: room.hotelName,
            hotelId: room.hotelId,
            number: room.number,
            roomId: room.id,
            clientName: $("#name").val(),
            clientLastName: $("#lastName").val(),
            clientPhone: $("#phone").val(),
            start: $("#start").val(),
            end: $("#end").val()
        };
        var today = new Date();
        if (order.start < today || order.start > order.end) {
            $("#dateError").html("Incorrect period, please, check your date.")
        } else {
            this.props.order(order);
            hashHistory.replace("/order/" + room.id + "/ready");
        }
    }

    render() {
        var { room } = this.props.roomState;
        var DateForm;
        switch (room.hotelType) {
            case 'Check in':
                DateForm =
                    <div>
                        <div class="form-group">
                            <label for="start">Start:</label>
                            <select class="form-control" id="start" required>
                                {room.dates.map((date) => {
                                    return(
                                        <option>{date}</option>
                                    )
                                })}
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="end">End:</label>
                            <select class="form-control" id="end" required>
                                {room.dates.map((date) => {
                                    return(
                                        <option>{date}</option>
                                    )
                                })}
                            </select>
                        </div>
                        <div class="well" id="dateError"></div>
                    </div>;

                break;
            case 'Daily':
                DateForm =
                    <div>
                        <div class="form-group">
                            <label for="start">Start:</label>
                            <input type="date" class="form-control" id="start" required/>
                        </div>
                        <div class="form-group">
                            <label for="end">End:</label>
                            <input type="date" class="form-control" id="end" required/>
                        </div>
                        <div class="well" id="dateError"></div>
                    </div>;

                break;
            default:
                break;
        }
        if (this.props.children) {
            return (
                <div>
                    {this.props.children}
                </div>
            )

        }
        return (
            <div>
                <h2>Booking a room #{room.number}</h2>
                <h3>Hotel type is "<strong>{room.hotelType}</strong>"</h3>
                <form role="form" onSubmit={(e) => { e.preventDefault(); this.order();}}>
                    <div class="col-sm-6">
                        <div class="form-group">
                            <label for="name">Name:</label>
                            <input type="text" class="form-control" id="name" required/>
                        </div>
                        <div class="form-group">
                            <label for="lastName">Last name:</label>
                            <input type="text" class="form-control" id="lastName" required/>
                        </div>
                        <div class="form-group">
                            <label for="phone">Phone:</label>
                            <input type="tel" class="form-control" id="phone" required/>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        {DateForm}
                    </div>
                    <div class="col-sm-12 text-center">
                        <button type="submit" class="btn btn-primary">Order</button>
                    </div>
                </form>
            </div>
        )
    }
}

export default Order;