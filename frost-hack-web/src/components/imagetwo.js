import { Parallax } from "react-parallax";
import img2 from "../image/a.jpg";

const ImageTwo = () => (
  <Parallax
    className="image"
    blur={0}
    bgImage={img2}
    strength={800}
    bgImageStyle={{ minHeight: "100vh" }}
  >
    <div className="content">
      <span className="img-txt">Emosense</span>
    </div>
  </Parallax>
);

export default ImageTwo;
