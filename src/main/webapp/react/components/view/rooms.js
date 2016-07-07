import react from 'react';
import * as Bootstrap from 'react-bootstrap';

class Room extends React.Component {}


class RoomsPanel extends React.Component {
    componentDidMount() {
        this.props.getRooms(this.props.location.query);
    }
    render() {
        var { rooms } = this.props;
        return(
            <div>
                <h3>Free rooms:</h3>
                <div class="col-sm-3">
                    <Bootstrap.Panel collapsible defaultExpanded header="Filters :">
                        <Bootstrap.ListGroup fill>
                            <Bootstrap.ListGroupItem>Item 1</Bootstrap.ListGroupItem>
                            <Bootstrap.ListGroupItem>Item 2</Bootstrap.ListGroupItem>
                            <Bootstrap.ListGroupItem>&hellip;</Bootstrap.ListGroupItem>
                        </Bootstrap.ListGroup>
                    </Bootstrap.Panel>
                </div>
                <div class="col-sm-9">
                    <div class="row">
                        {rooms.map((room) => {
                            return(
                                <Room room={room} key={room.id} />
                            )
                        })}
                    </div>
                </div>
            </div>
        )
    }
}

export default RoomsPanel;
