
import { useEffect, useState } from "react";
import axios from "axios";
import "bootstrap/dist/css/bootstrap.min.css";

function App() {
  const [stations, setStations] = useState([]);
  const [station, setStation] = useState({
    stationName: "",
    city: "",
    platformCount: "",
    stationCode: ""
  });
  const [editId, setEditId] = useState(null);
const API = "http://localhost:7001/station";
  const getStations = async () => {
    const response = await axios.get(`${API}/displayall`);
    setStations(response.data);
  };

  useEffect(() => {
    getStations();
  }, []);

  const handleChange = (e) => {
    setStation({ ...station, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    const data = {
      ...station,
      platformCount: Number(station.platformCount)
    };

    if (editId) {
      await axios.put(`${API}/update/${editId}`, data);
      setEditId(null);
    } else {
      await axios.post(`${API}/add`, data);
    }

    setStation({
      stationName: "",
      city: "",
      platformCount: "",
      stationCode: ""
    });

    getStations();
  };

  const handleEdit = (item) => {
    setStation({
      stationName: item.stationName,
      city: item.city,
      platformCount: item.platformCount,
      stationCode: item.stationCode
    });
    setEditId(item.id);
  };

  const handleDelete = async (id) => {
    if (window.confirm("Delete this station?")) {
      await axios.delete(`${API}/delete/${id}`);
      getStations();
    }
  };

  return (
    <div className="container mt-4">
      <h2 className="text-center mb-4">Train Station Management</h2>

      <form onSubmit={handleSubmit} className="card card-body mb-4">
        <input
          className="form-control mb-3"
          name="stationName"
          placeholder="Station Name"
          value={station.stationName}
          onChange={handleChange}
          required
        />

        <input
          className="form-control mb-3"
          name="city"
          placeholder="City"
          value={station.city}
          onChange={handleChange}
          required
        />

        <input
          className="form-control mb-3"
          type="number"
          min="1"
          name="platformCount"
          placeholder="Platform Count"
          value={station.platformCount}
          onChange={handleChange}
          required
        />

        <input
          className="form-control mb-3"
          name="stationCode"
          placeholder="Station Code"
          value={station.stationCode}
          onChange={handleChange}
          required
        />

        <button className="btn btn-primary" type="submit">
          {editId ? "Update Station" : "Add Station"}
        </button>
      </form>

      <table className="table table-bordered table-striped">
        <thead className="table-dark">
          <tr>
            <th>ID</th>
            <th>Station Name</th>
            <th>City</th>
            <th>Platforms</th>
            <th>Code</th>
            <th>Actions</th>
          </tr>
        </thead>

        <tbody>
          {stations.map((item) => (
            <tr key={item.id}>
              <td>{item.id}</td>
              <td>{item.stationName}</td>
              <td>{item.city}</td>
              <td>{item.platformCount}</td>
              <td>{item.stationCode}</td>
              <td>
                <button
                  type="button"
                  className="btn btn-warning btn-sm me-2"
                  onClick={() => handleEdit(item)}
                >
                  Edit
                </button>

                <button
                  type="button"
                  className="btn btn-danger btn-sm"
                  onClick={() => handleDelete(item.id)}
                >
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default App;
