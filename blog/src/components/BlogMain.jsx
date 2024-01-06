// rfce

// REACT
import React from 'react'

// I18N
import {withTranslation} from 'react-i18next'

// Css
import './main.css'

// Picture
import picture from '../assets/image/sunset-8327637_1280.jpg'

// Link
import {Link} from 'react-router-dom';

// TAILWIND
import {
    Button,
    Dialog,
    DialogHeader,
    DialogBody,
    DialogFooter,
    Card,
    CardHeader,
    CardBody,
    CardFooter,
    Typography,
} from "@material-tailwind/react";

//FUNCTION
function BlogMain() {

    // STATE 
    // USE EFFECT 
    // USE NAVIGATE

    // Modal
    const [open, setOpen] = React.useState(false);

    // Open
    const handleOpen = () => setOpen(!open);

    // RETURN
    return (
        <React.Fragment>
            <Card className="mt-6 w-96 container">
                <CardHeader color="blue-gray" className="relative h-56">
                    <Link to="/">Anasayfa</Link>
                    <img
                        src={picture}
                        //src="https://images.unsplash.com/photo-1540553016722-983e48a2cd10?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=800&q=80"
                        alt="card-image"
                    />
                </CardHeader>

                <CardBody>
                    <Typography variant="h5" color="blue-gray" className="mb-2">
                        UI/UX Review Check
                    </Typography>
                    <Typography>
                        The place is close to Barceloneta Beach and bus stop just 2 min by
                        walk and near to &quot;Naviglio&quot; where you can enjoy the main
                        night life in Barcelona.
                    </Typography>
                </CardBody>

                <CardFooter className="pt-0">
                    <Button>Read More</Button>
                </CardFooter>
            </Card>
            <p> t eius. Voluptatem, eius illum? Lorem e reeiciendis nihil! Nemo, quae repellendus.</p>
            {/* Modal */}
        </React.Fragment>
    ) //end Return
}// end Function

// EXPORT
export default withTranslation()(BlogMain);