//rcc
import React, { Component } from 'react';
import { withTranslation } from 'react-i18next';

// CLASS BlogHeader
class BlogHeader extends Component {

    // Display
    static displayName="Blog Header"

    //Construct 
    constructor(props) {
        super(props);

        //STATE
        this.state={};

        //BIND
        // this.method=this.method.bind(this);
    }

    // CDM

    // RENDER
    render() {

        //RETURN
        return (
            <div>
                
            </div>
        ); // end return
    } //end render
} //end class BlogHeader

//EXPORT
export default withTranslation()(BlogHeader) ;