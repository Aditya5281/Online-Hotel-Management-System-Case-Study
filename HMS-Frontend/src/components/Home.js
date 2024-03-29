import React, { Component } from "react";


import Banner from './Banner';
import OurRooms from "./OurRooms";
import Header from "./Header";
import Footer from "./Footer";

export default class Home extends Component {
    constructor(props) {
        super(props);

        this.state = {
            content: ""
        };
    }

    

    render() {
        return (
            <>
            <Header></Header>
            <div className="container" style={{marginTop:100}}>
                
                <Banner />
                <OurRooms />
            </div>
            <Footer></Footer>
            </>
        );
    }
}
