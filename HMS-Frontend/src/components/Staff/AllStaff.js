import { Button } from '@material-ui/core'
import React,{useState,useEffect} from 'react'
import StaffService from '../../services/StaffService'
import '../Room/AllRooms.css'
import Header from '../Header'
import Footer from '../Footer'

export default function AllStaff() {

    const [staff, setStaff] = useState([])
    // for Rest API call 
    useEffect(() => {
        getAllStaffs()
    }, [])
    const getAllStaffs=()=>{
        StaffService.getAllStaffs().then((response)=>{
            setStaff(response.data)
            console.log(response.data)
        }).catch(error => {
            console.log(error);
        })
    };
    const deleteStaff=(staffId)=>{
        StaffService.deleteStaff(staffId).then((response)=>{
            console.log(staffId);
            getAllStaffs();   
        }).catch(error => {
            console.log(error);
        })
    }
    return (
        <>
        <Header></Header>
            <div style={{ maxWidth: "100%", width: "90%" }} className='container'>
            <br></br><br></br><br></br>
            <h1>Staff List</h1>
            <table>
                <thead>
                    <tr>
                        <th>Staff ID</th>
                        <th>Staff Name</th>
                        <th>Staff Salary</th>
                        <th>Staff Email</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        staff.map(
                            staffDetails=>
                                <tr key={staffDetails.staffId}>
                                    <td>{staffDetails.staffId}</td>
                                    <td>{staffDetails.staffName}</td>
                                    <td>{staffDetails.staffSlary}</td>
                                    <td>{staffDetails.staffEmail}</td>
                                    <td>
                                        <Button variant='outlined' color='secondary' onClick={()=>deleteStaff(staffDetails.staffId)}>Delete</Button>
                                    </td>
                                </tr>
                        )
                    }
                </tbody>
            </table>
        </div>
        <Footer></Footer>
        </>
    )
}
