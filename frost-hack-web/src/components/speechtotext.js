import React from "react";
import SpeechRecognition, {
  useSpeechRecognition,
} from "react-speech-recognition";

const Speechtotext = () => {
  const {
    transcript,
    listening,
    resetTranscript,
    browserSupportSpeechRecogntion,
  } = useSpeechRecognition();
  if (!browserSupportSpeechRecogntion) {
    console.log("Your browser doesn't support speech to text");
  }
  return (
    <div>
      <p>Microphone: {listening ? "on" : "off"}</p>
      <button onClick={SpeechRecognition.startListening}>Start</button>
      <button onClick={SpeechRecognition.stopListening}>Stop</button>
      <button onClick={resetTranscript}>Reset</button>
      <p>{transcript}</p>
    </div>
  );
};

export default Speechtotext;
